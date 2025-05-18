// components/CustomerForm.jsx
import { useForm } from 'react-hook-form';

export default function CustomerForm({ initial = {}, onSave, onClose }) {
    const { register, handleSubmit, reset } = useForm({ defaultValues: initial });
    const submit = (data) => { onSave(data); reset(); };

    return (
        <div className="fixed inset-0 bg-black/50 flex items-center justify-center">
            <form onSubmit={handleSubmit(submit)} className="bg-white p-6 rounded-md shadow w-80 space-y-3">
                <h3 className="text-lg font-medium mb-2">{initial.id ? 'Edit' : 'New'} Customer</h3>

                <input type="hidden" {...register('id')} />

                <label className="block">
                    <span className="text-xs">Name</span>
                    <input className="input" {...register('name', { required: true })}/>
                </label>

                <label className="block">
                    <span className="text-xs">Email</span>
                    <input className="input" {...register('email', { required: true })}/>
                </label>

                <label className="block">
                    <span className="text-xs">Phone</span>
                    <input className="input" {...register('phone')}/>
                </label>

                <div className="flex justify-end space-x-2 pt-2">
                    <button type="button" className="btn" onClick={onClose}>Cancel</button>
                    <button className="btn-primary" type="submit">Save</button>
                </div>
            </form>
        </div>
    );
}
